import axios from 'axios';
import {observable, action} from 'mobx';

class CommentStore {

    static __instance = null;

    static getInstance() {
        if (CommentStore.__instance === null)
            CommentStore.__instance = new CommentStore();
        return CommentStore.__instance;
    }

    //javascript에서 private를 사용할 수 없기 때문에 클래스 외부에서 디폴트 생성자를 실행하지 못하게 하기 위한 장치
    constructor() {
        CommentStore.__instance = this;
    }

    @observable current_comment = null;

    @action insertComment = async (newComment) => {
        try {
            let response = await axios({
                url: `http://localhost:8080/api/comment/insert`,
                headers: {
                    'Content-Type': 'application/json; charset=UTF-8'
                },
                method: 'post',
                timeout: 3000,
                data: JSON.stringify(newComment)
            });
            return (response.status === 200)
        } catch (ex) {
            return false;
        }
    };

    @action getComment = async (product_id) => {
        let link = `http://localhost:8080/api/comment/selectProduct/${product_id}`;
        try {
            let response = await axios({
                url: link,
                headers: {
                    'Content-Type': 'application/json; charset=UTF-8'
                },
                method: 'get',
                timeout: 3000
            });
            if(response.data === ""){
                return false;
            }
            this.current_comment = response.data;
            return (response.status === 200)
        } catch (ex) {
            return false;
        }
    };

    @action logout = async () => {
        this.current_comment = null;
    };
}

export default CommentStore.getInstance();