<template>
  <div class="books">
    <h1>Books</h1>

    <h4 v-if="errors.length" class="error">{{errors}}</h4>
    <table class="table" v-if="books.length">
      <thead>
        <tr>
          <th scope="col">Title</th>
          <th scope="col">Author</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="book in books">
          <td>{{book.title}}</td>
          <td>{{book.author}}</td>
        </tr>
      </tbody>
    </table>
    <h4 v-if="!books.length && !errors.length">Loading...</h4>

  </div>
</template>

<script>
// import axios from 'axios'
import {AXIOS} from './http-common'

export default {
  name: 'books',

    data () {
      return {
        books: [],
        errors: []
      }
    },
    created() {
      AXIOS.get(`/books`)
        .then(response => {
          this.books = response.data
        })
        .catch(e => {
          this.errors.push(e)
        })
    }
}

</script>


<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
p {
  margin-bottom: 20px;
}

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
