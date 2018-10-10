<template>
  <div class="user">
    <p><a href="#" v-bind:id="'user-' + id" v-on:click.prevent="loadLoans(id)">{{name}} {{email}}</a></p>
    <ul v-if="loans.length">
      <h4>Loans</h4>
      <li v-for="loan in loans">{{loan.book.title}}</li>
    </ul>
    <p v-if="loansLoaded && !loans.length">No loans</p>
    <p v-if="errors.length">{{errors}}</p>
  </div>
</template>

<script>
  // import axios from 'axios'
  import {AXIOS} from './http-common'

  export default {
    name: 'user',
    props: {
      'id': Number,
      'name': String,
      'email': String
    },

    data () {
      return {
        loansLoaded: false,
        loans: [],
        errors: []
      }
    },
    methods: {
      loadLoans(userId) {
        AXIOS.get(`/loan/user/` + userId)
          .then(response => {
            this.loans = response.data;
            this.loansLoaded = true;
          })
          .catch(e => {
            this.errors.push(e)
          });
      }
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
