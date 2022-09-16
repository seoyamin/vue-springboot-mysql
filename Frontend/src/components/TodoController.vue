<template>
  <div class="controller">
    <div class="select">
      <label class="blind" for="order">Order</label>
      <select name="order" id="order" class="selectbox" v-model="selected" v-on:change="sortTodo">
        <option value="date-asc">Oldest</option>
        <option value="date-desc">Latest</option>
      </select>
    </div>
    <button class="clear" v-on:click="clearTodo">Clear All</button>
  </div>
</template>


<script>
import { mapMutations } from "vuex";

export default {
  data() {
    return {
      selected: "date-asc"
    };
  },
  methods: {
    ...mapMutations({
      clearTodo: "clearAllItem"
    }),

    sortTodo() {
      // 선택된 값에 따라 아이템 정렬
      if (this.selected === "date-desc") {
        this.$store.commit("sortTodoLatest");
      }

      else if (this.selected === "date-asc") {
        this.$store.commit("sortTodoOldest");
      }
    }
  }
};
</script>


<style>
.controller {
  display: flex;
  align-items: center;
  justify-content: center;
  margin: 10px 200px 0px 200px;
  padding: 20px;
  border-radius: 20px;
  background: #efefef;
}
.selectbox {
  width: 150px;
  height: 30px;
  margin-left: 7px;
}
.clear {
  margin-left: 5px;
}
</style>