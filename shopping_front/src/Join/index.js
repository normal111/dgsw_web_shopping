import React, {Component} from 'react';
import {inject, observer} from "mobx-react";
import {Redirect} from 'react-router-dom';

import './Join.scss';

@inject('stores')
@observer
class Join extends Component {

    state = {
        id: '',
        password: '',
        name: '',
        phone: '',
        mobile: '',
        postal_code: '',
        address: '',
        email: '',
        goToMain: false
    };

    render() {
        if (this.state.goToMain)
            return <Redirect to='/'/>;

        return (
            <div className='join-container'>
                <div className='join-text'>회원가입</div>
                <div className='join-content'>
                    DGSW Fashsion 가족을 위한 전문 쇼핑몰로 저렴한 가격과 신개념 고객서비스를 통해 고객 만족을 최우선으로 합니다. <br/>
                    쇼핑몰에 회원으로 가입하시면 보다 나은 편리합니다.
                </div>
                <div className='join-input'>
                    아이디 : <input id="id" type="text" placeholder="id" onChange={this.updateId}/><br/><br/>
                    패스워드 : <input id="password" type="password" placeholder="password"
                                  onChange={this.updatePassword}/><br/><br/>
                    성명 : <input id="name" type="text" placeholder="name" onChange={this.updateName}/><br/><br/>
                    전화번호 : <input id="phone" type="text" placeholder="phone" onChange={this.updatePhone}/><br/><br/>
                    휴대폰 : <input id="mobile" type="text" placeholder="mobile" onChange={this.updateMobile}/><br/><br/>
                    우편번호 : <input id="postal_code" type="text" placeholder="postal_code"
                                  onChange={this.updatePostal_code}/><br/><br/>
                    주소 <input id="address" type="text" placeholder="address" onChange={this.updateAddress}/><br/><br/>
                    이메일 : <input id="email" type="text" placeholder="email" onChange={this.updateEmail}/><br/><br/>
                </div>
                <button className='join-button' onClick={this.join}>회원가입</button>
            </div>
        );
    }

    join = async () => {
        let result = await this.props.stores.UserStore.addNewUser(this.state);
        if (result === true) {
            alert("가입 성공");
            this.setState({goToMain: true});
        } else {
            alert("가입 실패");
        }
    };

    updateId = event => {
        this.setState({
            ...this.state,
            id: event.target.value
        });
    };

    updatePassword = event => {
        this.setState({
            ...this.state,
            password: event.target.value
        });
    };

    updateName = event => {
        this.setState({
            ...this.state,
            name: event.target.value
        });
    };

    updatePhone = event => {
        this.setState({
            ...this.state,
            phone: event.target.value
        });
    };

    updateMobile = event => {
        this.setState({
            ...this.state,
            mobile: event.target.value
        });
    };

    updatePostal_code = event => {
        this.setState({
            ...this.state,
            postal_code: event.target.value
        });
    };

    updateAddress = event => {
        this.setState({
            ...this.state,
            address: event.target.value
        });
    };

    updateEmail = event => {
        this.setState({
            ...this.state,
            email: event.target.value
        });
    };

}

export default Join;