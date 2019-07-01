import React, {Component} from 'react';
import {inject, observer} from "mobx-react";

import './Cart.scss'

import CartItem from "./CartItem";

@inject('stores')
@observer
class Cart extends Component {
    state = {
        user_id: null,
        cart: []
    };

    async componentDidMount() {
        if (this.props.stores.UserStore.current_user !== null && this.props.stores.UserStore.current_user.id !== "") {
            let user_id = this.props.stores.UserStore.current_user.id;
            await this.props.stores.CartStore.getCart(user_id);
            this.setState({
                user_id: user_id,
                cart: this.props.stores.CartStore.current_cart
            });
        } else {
            alert("잘못된 접근입니다");
            this.setState({
                goToMain: true
            });
        }
    }

    render() {
        return (
            <div className='cart-container'>
                <div className='cart-text'>
                    장바구니
                </div>
                <br/>
                <div className='cart-item-header'>
                    <div className='cart-item-name'>이름</div>
                    <div className='cart-item-price'>가격</div>
                    <div className='cart-item-count'>개수</div>
                    <div className='cart-item-total'>총</div>
                    <div className='cart-item-delete'>삭제</div>
                </div>
                <div className='cart-item-body'>
                    {
                        this.state.cart.map(item => {
                                return (<CartItem key={item.id} cart_id={item.id} product_id={item.product_id}
                                                  count={item.count}></CartItem>)
                            }
                        )
                    }
                </div>

                <div>
                    <button onClick={this.paymentCartAll}>모두 결제하기</button>
                </div>
            </div>
        );
    }

    paymentCartAll = async () => {
        await this.props.stores.CartStore.paymentAllCart((this.state.user_id));
        alert("결제완료!");
        this.setState({
            cart: []
        });
    }
}

export default Cart;