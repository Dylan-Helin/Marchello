<template>
  <div id="app">
    <div id="nav">
      <marchello-header />
    </div>
    <router-view />
  </div>
</template>
<script>
import MarchelloHeader from './components/MarchelloHeader';
export default {
  components: { MarchelloHeader }
};
</script>
<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: aliceblue;
}

#nav {
  padding: 30px;

  a {
    font-weight: bold;
    color: white;

    &.router-link-exact-active {
      color: #B6FFF6;
    }
  }
}
</style>
