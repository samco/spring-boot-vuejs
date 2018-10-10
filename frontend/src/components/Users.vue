<template>
  <div class="users">
    <h1>List Users</h1>

    <h4 v-if="errors.length" class="error">{{errors}}</h4>
    <h4 v-if="response.length">{{response}}</h4>
    <h4 v-if="!response.length && !errors.length" class="loading">Loading...</h4>

  </div>
</template>

<script>
  // import axios from 'axios'
  import {AXIOS} from './http-common'

  export default {
    name: 'users',

    data () {
      return {
        response: [],
        errors: []
      }
    },
    created() {
      AXIOS.get(`/users`)
        .then(response => {
          this.response = response.data
        })
        .catch(e => {
          this.errors.push(e)
        })
    }
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
