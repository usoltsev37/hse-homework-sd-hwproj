<template>
  <div class="display-board">
    <h4>Homeworks Published</h4>
    <div class="number">
      {{numberOfHws}}
    </div>
    <div class="btn">
      <button @click='getHomeworks()' type="button" class="btn btn-warning">Add homework</button>
    </div>
  </div>
</template>

<script>
export default {
  name: 'addHomework',
  props: ['numberOfHws'],
  methods: {
    getHomeworks() {
      this.$emit('addHomework')
    }
  }
}
</script>