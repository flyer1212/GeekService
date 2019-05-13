import Vue from 'vue'
import Vuex from 'vuex'
import { stat } from 'fs';

Vue.use(Vuex)

export default new Vuex.Store({
    state: sessionStorage.getItem('state') ? JSON.parse(sessionStorage.getItem('state')):{
        city: '上海',
        userId:'',
        userName:'',
        token:'',
        login_in_or_not: false
    },
    mutations: {
        changeCity(state, city) {
            state.city = city;
        },
        changeUserId(state, userId) {
            state.userId = userId;
        },
        changeUserName(state, userName) {
            state.userName = userName;
        },
        changeToken(state, token) {
            state.token = token;
        },
        changeLoginOrNot(state, login_in_or_not) {
            state.login_in_or_not = login_in_or_not;
        }
    }
})