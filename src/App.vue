<template>
    <div id="app">
        <chat-head v-for="head in heads" :key="head.id" :data="head" ></chat-head>
        <button @click="onclicked">Button</button>
    </div>
</template>

<script>
export default {
    data () {
        return {
            heads: [ {id: 3, msg: "Yeye", num: 1 },
                     {id: 2, msg: "Yeye", num: 5 },
                     {id: 1, msg: "Yeye", num: 2 },
                     { id: 0, msg: "hello", num: 7 }]
        }
    },

    methods :{

            onclicked() {
                this.heads = this.heads.sort(function(a, b) {
                    return a.num - b.num;
                });
                console.log(this.heads);
                console.log("hello world");
            }

    }
}
</script>

<style lang="scss">

</style>
