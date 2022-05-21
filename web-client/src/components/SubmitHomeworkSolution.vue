<template>
  <div class="display-board">
    <input v-model="message" placeholder="Link to github" />
    <div class="btn">
      <button @click='submitHomeworkSolution()' type="button" class="btn btn-warning">Submit homework</button>
    </div>
  </div>
</template>

<script>
export default {
  name: 'submitHomeworkSolution',
  props: ['numberOfHws'],
  methods: {
    submitHomeworkSolution() {
      this.$emit('submitHomeworkSolution')
    }
  }
}
</script>