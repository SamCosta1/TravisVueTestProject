<template>
    <div id="app">
        <h1>Data: {{ jsonData.data }} </h1>
        <button @click="onclicked">Button</button>
        <chat-head v-for="head in heads" :key="head.id" :data="head"></chat-head>
    </div>
</template>

<script>


export default {
    data () {
        return {
            numHeads: 4,
            heads: [
                     {id: 2, msg: "Yeye", num: 5 },
                     {id: 1, msg: "Yeye", num: 2 },
                     { id: 0, msg: "hello", num: 7 },
                     {id: 3, msg: "Yeye", num: 1 }],
            jsonData: { data: "Hello world" },

        }
    },

    methods :{

            onclicked() {
                this.heads = this.heads.sort(function(a, b) {
                    return a.num - b.num;
                });
                //console.log(this.heads);
                console.log("hello world");
            },

            onLoad() {
                var href = window.location.href.replace("8008", "8080");
                var test = this.jsonData;
                var heads = this.heads;

                $.get(href + "Server", function (responseJson) {    // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response JSON...
                    console.log("Response:" ,responseJson);
                    test.data = responseJson.hello;

                    responseJson.heads.forEach((head) => {
                        heads.push({id: this.numHeads++, msg: head, num: Math.random() * 10})
                    });

                });
                //this.onclicked();
                setTimeout(this.onLoad, 2000);

            }


    },

    mounted() {
        this.onLoad();
    }
}

/*
$(document).ready(function () {
    jsonData = "tara";
    var href = window.location.href.replace("8008", "8080");
    console.log("here I am");
    $.get(href + "Server", function (responseJson) {    // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response JSON...
        console.log("Response:" ,responseJson);
        jsonData = responseJson.sqltest;
    });

});*/
    setTimeout(function(){ console.log("Hello"); }, 300);

</script>

<style lang="scss">
</style>
