import axios from 'axios';
import {observable, action} from 'mobx';

class UserStore {

    static __instance = null;

    static getInstance() {
        if (UserStore.__instance === null)
            UserStore.__instance = new UserStore();
        return UserStore.__instance;
    }

    //javascript에서 private를 사용할 수 없기 때문에 클래스 외부에서 디폴트 생성자를 실행하지 못하게 하기 위한 장치
    constructor() {
        UserStore.__instance = this;
    }

    @observable current_user = null;

    @action addNewUser = async (newUser) => {
        try {
            let response = await axios({
                url: `http://localhost:8080/api/user/insert`,
                headers: {
                    'Content-Type': 'application/json; charset=UTF-8'
                },
                method: 'post',
                timeout: 3000,
                data: JSON.stringify(newUser)
            });
            return (response.status === 200)
        } catch (ex) {
            return false;
        }
    };

    @action loginUser = async (user) => {
        try {
            let response = await axios({
                url: `http://localhost:8080/api/user/login`,
                headers: {
                    'Content-Type': 'application/json; charset=UTF-8'
                },
                method: 'post',
                timeout: 3000,
                data: JSON.stringify(user)
            });
            if(response.data === ""){
                return false;
            }
            this.current_user = response.data;
            return (response.status === 200)
        } catch (ex) {
            return false;
        }
    };

    @action logout = async () => {
        this.current_user = null;
    };
}

export default UserStore.getInstance();