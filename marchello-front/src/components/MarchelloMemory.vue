<template>
  <div>
    <table>
      <thead>
        <tr>
          <th>Nom</th>
          <th>message</th>
          <th>Date d'envoi</th>
        </tr>
      </thead>
      <tbody>
        <tr
          v-for="(message, index) in messages"
          :key="index"
        >
          <td>
            {{ message.senderName | upperCaseFilter }}
          </td>
          <td>
            {{ message.message }}
          </td>
          <td>
            {{ message.date }}
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import marchelloApi from "../api/marchelloApi";
export default {
  name: 'MarchelloMemory',
  data() {
    return {
      messages: ''
    };
  },
  methods: {
    async getAllMessages() {
      try {
        const response = await marchelloApi.getAllMessage();
        this.messages = response.body;
      } catch (error) {
        console.error('Marchello à un trou de mémoire');
      }
    }
  },
  async mounted() {
    await this.getAllMessages();
  }
};
</script>
<style scoped>
th
{
color: #B6FFF6;
}
table
{
margin: auto;
}
td
{
text-align :center;
}
</style>
