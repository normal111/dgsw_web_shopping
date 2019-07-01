import React, {Component} from 'react';
import {inject, observer} from "mobx-react";

import './CartItem.scss';

@inject('stores')
@observer
class CartItem extends Component {
    state = {
        cart_id: null,
        product: null,
        count: 0
    };

    async componentDidMount() {
        this.state.cart_id = this.props.cart_id;
        this.state.count = this.props.count;
        let product_id = this.props.product_id;
        this.setState({
            product: await this.props.stores.ProductStore.getProduct(product_id)
        });
        // sum = this.state.sum + parseInt(product.price) * parseInt(cart_count)
    }

    render() {
        if (this.state.product == null)
            return (<div></div>);

        return (
            <div className='cart-item-info'>
                <div className='cart-item-name'>{this.state.product.name}</div>
                <div className='cart-item-price'>{this.state.product.price}</div>
                <div className='cart-item-count'>{this.state.count}</div>
                <div className='cart-item-total'>{parseInt(this.state.product.price) * parseInt(this.state.count)}</div>
                <div className='cart-item-delete'>
                    <button onClick={this.deleteCartItem}>삭제</button>
                </div>
            </div>
        );
    }

    deleteCartItem = async () => {
        await this.props.stores.CartStore.deleteCart((this.state.cart_id));
        alert("장바구니에서 삭제되었습니다.");
        this.setState({
            cart_id: null,
            product: null,
            count: 0
        });
    }
}

export default CartItem;