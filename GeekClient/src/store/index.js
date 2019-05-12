import Vue from 'vue'
import Vuex from 'vuex'
import { stat } from 'fs';

Vue.use(Vuex)

export default new Vuex.Store({
    state: sessionStorage.getItem('state') ? JSON.parse(sessionStorage.getItem('state')):{
        city: '上海',
        qqNumber: '',
        password: '',
        u_uid:'',
        login_in_or_not: 'false'
    },
    mutations: {
        changeCity(state, city) {
            state.city = city;
        },
        changeQqNumber(state, qqNumber) {
            state.qqNumber = qqNumber;
        },
        changePassword(state, password) {
            state.password = password;
        },
        changeUuid(state, u_uid) {
            state.u_uid = u_uid;
        },
        changeLoginOrNot(state, login_in_or_not) {
            state.login_in_or_not = login_in_or_not;
        }
    }
})