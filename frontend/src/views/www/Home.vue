<template>
	<div>
		<img alt="Vue logo" src="@/assets/logo.png" />
		<search />
		<TestComponent />
	</div>
</template>

<script>
import Search from '@/components/Search.vue';
import TestComponent from '@/test/TestComponent';
export default {
	components: {
		Search,
		TestComponent,
	},
};
</script>

<style></style>
