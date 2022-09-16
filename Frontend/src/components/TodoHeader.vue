<template>
  <header class="header">
    <h1 class="logo">
      <span class="blind">My Todo</span>
    </h1>
    <p class="header__date">{{ timestamp }}</p>
  </header>
</template>

<script>
import getDate from "../assets/common/getDate.js";
export default {
  data() {
    return {
      timestamp: ""
    };
  },
  created() {
    this.timestamp = `${getDate().month}/${getDate().date} ${getDate().week}`;
  }
};
</script>


<style>
.logo {
  font-size: 50px;
  color: #42b983;
}
.date {
  font-size: 20px;
  color: #9d9d9d;
}
</style>