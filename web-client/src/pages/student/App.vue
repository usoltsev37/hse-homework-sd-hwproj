<template>
  <h1>Student Page</h1>
  <StudentPage/>
  <TestComponent msg="РАБОТАЙ СУКААА"/>
</template>

<script>
import StudentPage from "@/components/StudentPage";
import TestComponent from "@/components/TestComponent";

export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: 'Student',
  components: {
    StudentPage,
    TestComponent
  }
}
</script>

<style>

.button {
  border: none;
  color: white;
  padding: 16px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  transition-duration: 0.4s;
  cursor: pointer;
}
</style>
