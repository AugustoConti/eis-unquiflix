<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<style>
  /* #app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 60px;
  }*/

  #barra-principal{
    height: 5rem;
  }
  
  .div-select{
    width: 15rem;
  }

  body {
    background: url("../src/assets/background-main.png");
    background-color:black;
  }

  .container-fluid{
    padding-left:0!important;
    padding-right:0!important;
  }
</style>