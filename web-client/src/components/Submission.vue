<template>
  <h2>Submissions</h2>

  <div class="display-board mrgnbtm">
    <div class="submission mrgnbtm">
      <input type="text" v-model="solution" placeholder="Link to github"/>
      <input type="number" v-model="hwId" placeholder="hw id" />
    </div>
    <div class="btn">
      <button @click='submitSolution()' type="button" class="btn btn-warning">Submit homework</button>
    </div>
  </div>

  <div class="subs">
    <div class="container mrgnbtm">
      <button @click='getSubmissions()' type="button" class="btn btn-warning">Show Submissions</button>
    </div>
    <SubmissionTable v-if="submissions.length > 0" :submissions="submissions"/>
  </div>
</template>

<script>
import SubmissionTable from "@/components/SubmissionTable";
import {getSubmissions} from "@/services/HwService";

export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Submission",
  components: {
    SubmissionTable
  },

  data() {
    return {
      solution: '',
      hwId: '',
      submissions: []
    }
  },

  methods: {
    submitSolution() {
       const payload = {
         hwId: this.hwId,
         solution: this.solution,
         createdAt: new Date().toISOString()
       }
       this.$emit('submitSolution', payload)
       this.clearForm()
    },

    getSubmissions() {
      const params = {
        isTeacher: false
      }

      getSubmissions(params).then(response => {
        this.submissions = response
      })
    },

    clearForm() {
      this.hwId = '';
      this.solution = '';
    }
  }
}
</script>

<style scoped>
input {
  margin-right: 4px;
}
</style>