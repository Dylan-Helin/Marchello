<template>
  <div>
    <form @submit.prevent="saveBeer">
      <p>
        Message :
        <input
          v-model="message.message"
          type="text"
          required
        >
      </p><div v-if="errorMessage.name">
        {{ errorMessage.message }}
      </div>
      <button
        type="submit"
        :disabled="!formIsValid"
      >
        Envoyer
      </button>
      <p v-if="genericError">
        Une erreur est survenue lors de la création de ce message.
      </p>
    </form>
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
        message: '',
        senderName: '',
        date: ''
      },
      errorMessage: {}
    };
  },
  computed: {
    formIsValid() {
      return this.message.message !== '';
    }
  },
  methods: {
    async saveBeer() {
      try {
        if (this.formIsValid) {
          await marchelloApi.createMessage(this.message);
          this.goToList();
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

</style>
