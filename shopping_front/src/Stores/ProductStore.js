import axios from 'axios';
import {action, observable} from 'mobx';

class ProductStore {

    static __instance = null;

    static getInstance() {
        if (ProductStore.__instance === null)
            ProductStore.__instance = new ProductStore();
        return ProductStore.__instance;
    }

    //javascript에서 private를 사용할 수 없기 때문에 클래스 외부에서 디폴트 생성자를 실행하지 못하게 하기 위한 장치
    constructor() {
        ProductStore.__instance = this;
    }

    @observable current_product = null;

    @action getProduct = async (product_id) => {
        try {
            let response = await axios({
                url: `http://localhost:8080/api/product/select/${product_id}`,
                headers: {
                    'Content-Type': 'application/json; charset=UTF-8'
                },
                method: 'get',
                timeout: 3000
            });

            if (response.status === 200) {
                return response.data;
            }
        } catch (ex) {
            return null;
        }
    };

    @action setProduct = async (product_id) => {
        try {
            let response = await axios({
                url: `http://localhost:8080/api/product/select/${product_id}`,
                headers: {
                    'Content-Type': 'application/json; charset=UTF-8'
                },
                method: 'get',
                timeout: 3000
            });

            if (response.status === 200) {
                this.current_product = response.data;
                return true;
            }
        } catch (ex) {
            return false;
        }
    };

}

export default ProductStore.getInstance();