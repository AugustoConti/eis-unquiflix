<template>
  <div class="Home">
    <img alt="Vue logo" src="../assets/logo.png">
    <HelloWorld msg="Welcome to Your Vue.js App"/>
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/ingreso'

export default {
  name: 'Home',
  components: {
    ingreso
  }
}
</script>


