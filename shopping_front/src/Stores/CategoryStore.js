import axios from 'axios';
import {observable, action} from 'mobx';

class CategoryStore {

    static __instance = null;

    static getInstance() {
        if (CategoryStore.__instance === null)
            CategoryStore.__instance = new CategoryStore();
        return CategoryStore.__instance;
    }

    //javascript에서 private를 사용할 수 없기 때문에 클래스 외부에서 디폴트 생성자를 실행하지 못하게 하기 위한 장치
    constructor() {
        CategoryStore.__instance = this;
    }

    @observable current_category = null;

    @action getCategory = async () => {
        try {
            let response = await axios({
                url: `http://localhost:8080/api/category/select`,
                headers: {
                    'Accept': 'application/json; charset=UTF-8'
                },
                method: 'get',
                timeout: 3000
            });
            if (response.status === 200) {
                this.current_category = response.data;
                return true;
            }
        } catch (ex) {
            return false;
        }
    };

}

export default CategoryStore.getInstance();