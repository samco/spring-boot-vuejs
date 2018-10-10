<template>
  <div class="users">
    <h1>Users</h1>

    <h4 v-if="errors.length" class="error" v-for="error in errors">{{error}}</h4>
    <user v-if="users.length" v-for="user in users" v-bind="user"/>
    <h4 v-if="!users.length && !errors.length" class="loading">Loading...</h4>

  </div>
</template>

<script>
  import User from './User'
  import {AXIOS} from './http-common'

  export default {
    name: 'users',
    components: {
      'user': User
    },
    data () {
      return {
        users: [],
        errors: []
      }
    },
    created() {
      AXIOS.get(`/users`)
        .then(response => {
          this.users = response.data
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
