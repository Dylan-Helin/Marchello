<template>
  <div>
    <div id="discussion">
      <div
        v-for="(m, index) in messages"
        id="message"
        :key="index"
      >
        <div
          v-if="m.senderName === 'Marchello'"
        >
          <p style="text-align: right">
            <b><i>Marchello :</i></b>
            <br>
            {{ m.message }}
          </p>
        </div>
        <div
          v-else
        >
          <p style="text-align: left">
            <b><i>Roberto :</i></b>
            <br>
            {{ m.message }}
          </p>
        </div>
      </div>
    </div>
    <div
      style="margin-right: 10%;
            margin-left: 10%;"
    >
      <form @submit.prevent="saveMessage">
        <div
          v-if="messages.length === 0"
        >
          <table style="margin: auto;">
            <tr>
              <td>
                <p>
                  Roberto :
                  <input
                    v-model="message.message"
                    type="text"
                    size="50"
                    required
                  >
                </p>
              </td>
              <td>
                <div v-if="errorMessage.name">
                  {{ errorMessage.message }}
                </div>
                <button
                  type="submit"
                  :disabled="!formIsValid"
                >
                  Envoyer
                </button>
              </td>
            </tr>
          </table>
        </div>
        <div
          v-else
        >
          <table style="margin: auto; margin-right: 0;">
            <tr>
              <td>
                <p>
                  Roberto :
                  <input
                    v-model="message.message"
                    type="text"
                    size="50"
                    required
                  >
                </p>
              </td>
              <td>
                <div v-if="errorMessage.name">
                  {{ errorMessage.message }}
                </div>
                <button
                  type="submit"
                  :disabled="!formIsValid"
                >
                  Envoyer
                </button>
              </td>
            </tr>
          </table>
        </div>
        <p v-if="genericError">
          Marchello n'a pas compris votre message
        </p>
      </form>
    </div>
  </div>
</template>

<script>
import marchelloApi from '../api/marchelloApi';

export default {
  name: 'MarchelloChat',
  data() {
    return {
      genericError: false,
      message: {
        senderName: '',
        message: '',
        date: ''
      },
      messages: [],
      errorMessage: {}
    };
  },
  computed: {
    formIsValid() {
      return this.message.message !== '';
    }
  },
  methods: {
    async saveMessage() {
      try {
        if (this.formIsValid) {
          this.message.senderName = 'Roberto';
          // Setting the date of today.
          let today = new Date();
          var dd = String(today.getDate()).padStart(2, '0');
          var mm = String(today.getMonth() + 1).padStart(2, '0');
          var yyyy = today.getFullYear();
          today = yyyy + '-' + mm + '-' + dd;
          this.message.date = today;
          await marchelloApi.createMessage(this.message);
          this.messages.push(Object.assign({}, this.message));
          this.message.senderName = 'Marchello';
          // If Roberto says "Comment est votre blanquette ?" it triggers an event.
          if (this.message.message === 'Comment est votre blanquette ?') {
            this.message.message = 'Elle est bonne';
          } else {
            if (this.messages.length >= 3) {
              if (this.messages[this.messages.length - 3].message === 'Comment est votre blanquette ?' && this.message.message === 'On me dit le plus grand bien des harengs pomme-à-l’huile') {
                this.message.message = 'Le patron vous en apportera un ramequin, vous vous ferez une idée';
              }
            }
          }
          // Make Marchello repeat or answer Roberto
          await marchelloApi.createMessage(this.message);
          this.messages.push(Object.assign({}, this.message));
          this.message.message = '';
        } else {
          if (this.message.message === '') {
            this.errorMessage.message = 'Le message est obligatoire.';
          }
        }
      } catch (error) {
        this.genericError = true;
        console.error('Erreur lors de la création d\'un message');
      }
    }
  }
};
</script>

<style scoped>
#discussion {
  background-color: #0C0C0C;
  align-content: center;
  border-radius: 10px;
  margin-right: 10%;
  margin-left: 10%;
  padding-right: 10px;
  padding-left: 10px;
}
#message {
  padding-top: 10px;
  padding-bottom: 10px;
}
</style>
