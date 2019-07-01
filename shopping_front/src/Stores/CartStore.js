import axios from 'axios';
import {action, observable} from 'mobx';

class CartStore {

    static __instance = null;

    static getInstance() {
        if (CartStore.__instance === null)
            CartStore.__instance = new CartStore();
        return CartStore.__instance;
    }

    //javascript에서 private를 사용할 수 없기 때문에 클래스 외부에서 디폴트 생성자를 실행하지 못하게 하기 위한 장치
    constructor() {
        CartStore.__instance = this;
    }

    @observable current_cart = null;

    @action addCart = async (newCart) => {
        try {
            let response = await axios({
                url: `http://localhost:8080/api/cart/insert`,
                headers: {
                    'Content-Type': 'application/json; charset=UTF-8'
                },
                method: 'post',
                timeout: 3000,
                data: JSON.stringify(newCart)
            });
            return (response.status === 200)
        } catch (ex) {
            return false;
        }
    };

    @action getCart = async (user_id) => {
        try {
            let response = await axios({
                url: `http://localhost:8080/api/cart/get/${user_id}`,
                headers: {
                    'Content-Type': 'application/json; charset=UTF-8'
                },
                method: 'get',
                timeout: 3000
            });
            if (response.status === 200) {
                this.current_cart = response.data;
                return true;
            }
        } catch (ex) {
            return false;
        }
    };

    @action deleteCart = async (cart_id) => {
        try {
            let response = await axios({
                url: `http://localhost:8080/api/cart/delete/${cart_id}`,
                headers: {
                    'Content-Type': 'application/json; charset=UTF-8'
                },
                method: 'delete',
                timeout: 3000
            });
            if (response.status === 200) {
                return true;
            }
        } catch (ex) {
            return false;
        }
    };

    @action paymentAllCart = async (user_id) => {
        try {
            let response = await axios({
                url: `http://localhost:8080/api/cart/paymentAll/${user_id}`,
                headers: {
                    'Content-Type': 'application/json; charset=UTF-8'
                },
                method: 'delete',
                timeout: 3000
            });
            if (response.status === 200) {
                return true;
            }
        } catch (ex) {
            return false;
        }
    };
}

export default CartStore.getInstance();