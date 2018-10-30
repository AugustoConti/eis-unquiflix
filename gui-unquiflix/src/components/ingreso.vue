<template>
    <div>

    <!-- <button disabled="disabled">Ingresar</button> -->
    <router-link class="btn btn-primary" to="/component1">Ingresar</router-link>
    
    <!-- <ul>
        <li v-for="item in items" :key="item" >
            {{ item.message }} 
        </li>
    </ul>    -->

    <!-- <router-view/>  -->
    </div>
</template>

<script>

export default {
    name: 'ingreso',
    data() {
        return {
            items: [
            { message: 'Foo' },
            { message: 'Bar' }
        ]
        }
        
    }
   
  
    
}
</script>