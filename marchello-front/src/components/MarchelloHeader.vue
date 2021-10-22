$<template>
  <div>
    <router-link
      class="test"
      :to="{path: '/'}"
    >
      Discussion
    </router-link>
    <router-link
      class="test"
      :to="{path: '/memory'}"
    >
      Souvenirs de Marchello
    </router-link>
  </div>
</template>

<script>
export default {
  name: 'MarchelloHeader'
};
</script>
<style lang="scss">
  .test:hover {
    transition: 0.5s;
    color: #42b983;
  };
</style>
