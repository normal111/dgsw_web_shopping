import React, {Component} from 'react';
import {inject, observer} from "mobx-react";
import {Redirect} from "react-router-dom";

import './Cart.scss'

import SimpleProduct from "../Product/SimpleProduct";

@inject('stores')
@observer
class Cart extends Component {
    state = {
        cart: [],
        goToMain: false
    };

    async componentDidMount() {
        if (this.props.stores.UserStore.current_user !== null && this.props.stores.UserStore.current_user.id !== "") {
            let user_id = this.props.stores.UserStore.current_user.id;
            await this.props.stores.CartStore.getCart(user_id);
            this.setState({
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
        if (this.state.goToMain)
            return <Redirect to='/'/>;

        let sum = 0;

        return (
            <div className='cart-container'>
                <ul>
                    {
                        this.state.cart.map(item => {
                                // sum += parseInt(item.price) * parseInt(item.count);
                                return (<li className='cart-item' key={item.id}>
                                    <SimpleProduct product_id={item.product_id}/>
                                    * {item.count}개</li>)
                            }
                        )
                    }
                </ul>

                <div>
                    {sum}
                </div>
            </div>
        );
    }
}

export default Cart;