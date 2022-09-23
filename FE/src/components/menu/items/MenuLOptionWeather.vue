<template>
    <b-card id="menu_card">
        <b-card-body>
            <b-row>
                <b-col cols="4">
                    <b-card class="inner_card" style="background-color:#1a2844; color:white">
                        <div id="tempt"></div>
                        <div>기온</div>
                        <b-card-text> 36.5 </b-card-text>
                    </b-card>
                </b-col>
                <b-col cols="4">
                    <b-card class="inner_card" style="background-color:#1a2844; color:white">
                        <div id="humidity"></div>
                        <div>습도</div>
                        <b-card-text>17</b-card-text>
                    </b-card>
                </b-col>
                <b-col cols="4">
                    <b-card class="inner_card" style="background-color:#1a2844; color:white">
                        <div id="rainy"></div>
                        <div>강우량</div>
                        <b-card-text>17</b-card-text>
                    </b-card>
                </b-col>
            </b-row>
        </b-card-body>
    </b-card>
</template>

<script>
export default {

}
</script>

<style>

</style>