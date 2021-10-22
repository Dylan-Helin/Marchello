$<template>
  <div>
    <router-link :to="{path: '/'}">
      Discussion
    </router-link>
    <router-link :to="{path: '/memory'}">
      souvenirs de Marchello
    </router-link>
  </div>
</template>

<script>
export default {
  name: 'MarchelloHeader'
};
</script>

<style scoped>

</style>
