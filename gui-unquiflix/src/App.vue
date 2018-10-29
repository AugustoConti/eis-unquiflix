<template>
  <div id="app">
    <nav id="barra-principal" class="navbar navbar-dark bg-dark sticky-top">
      <!-- Navbar content -->
      <ul class="nav">
        <li class="nav-item">
          <router-link to="/">Home</router-link>
        </li>
        <!--    <li class="nav-item">
            <router-link to="/about">About</router-link>
          </li> -->
        </ul>
        <div class="div-select">
          <select class="custom-select" name="" id="">
            <option value="" disabled selected hidden>Elegir el genero...</option>
            <option value="">Terror</option>
            <option value="">Romantica</option>
          </select>
        </div>

      </nav>

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
    } */


    #barra-principal{
      height: 3rem;
    }
    .div-select{
      width: 15rem;
    }
    body {
      /* background-color: black; */

      background: url("../src/assets/unquiflix.jpg") no-repeat center center fixed;

      background-size: cover;

    }



  </style>
