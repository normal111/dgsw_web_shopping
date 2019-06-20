import React, {Component} from 'react';
import {Link} from 'react-router-dom';

class Home extends Component {

    render() {
        return (
            <div>
                <button><Link to='/login'>로그인</Link></button>
                <button><Link to='/join'>회원가입</Link></button>
            </div>
        );
    }

}

export default Home;