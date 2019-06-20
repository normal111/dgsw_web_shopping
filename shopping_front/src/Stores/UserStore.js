import {action} from 'mobx';
import axios from 'axios';

class UserStore{
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
        } catch(ex) {
            alert(ex.toString());
            return false;
        }
    };
}

export default UserStore;