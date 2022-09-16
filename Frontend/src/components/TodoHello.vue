<template>
  <div className="hello">
    <p className="hello__guide">
      <span className="hello__guide-text">Nice to meet you!</span>
      <span className="hello__guide-text">I’m going to remember your tasks.</span>
    </p>
    <p className="hello__ask">What is your name?</p>
    <label htmlFor="user-name">Name</label>
    <div className="main-input">
      <input
          className="hello__input"
          type="text"
          id="user-name"
          placeholder="Let me know your name"
          v-model="userName"
          v-on:keypress.enter="addUserName(userName)"
      />
      <button className="hello__button">
        <span className="blind">Enter</span>
      </button>
    </div>
  </div>
</template>


<script>
import { mapMutations } from "vuex"

export default {
  data() {
    return {
      userName: ""
    }
  },

  methods : {
    ...mapMutations({
      addUserName: "setUserName"
    })
  }
}
</script>