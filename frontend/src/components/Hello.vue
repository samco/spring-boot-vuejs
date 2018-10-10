<template>
  <div class="hello">
    <h1>NLA</h1>
    <h2>See the sources here: </h2>
    <ul>
      <li><a href="https://github.com/samco/spring-boot-vuejs" target="_blank">github.com/samco/spring-boot-vuejs</a></li>
    </ul>
    <h2>On with the show</h2>
    <ul>
      <li><router-link :to="{ name: 'Users' }" exact>/users</router-link></li>
      <li><router-link :to="{ name: 'Books' }" exact>/books</router-link></li>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'hello',
}

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}
</style>
