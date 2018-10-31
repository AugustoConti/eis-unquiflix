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

      background: url("../src/assets/logobackChicoNegro.png") no-repeat center center fixed black !important;
      background-color:black;



    }

    .btn-primary{
      background: rgb(22, 96, 57);

      color: white;
      margin: 0px 10px 0px 10px;
      padding: 0 20px;
      border-radius: 5px;
      height: 50px;
      line-height: 50px;
      text-align: center;
    }


  </style>
