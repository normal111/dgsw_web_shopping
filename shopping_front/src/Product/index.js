import React, {Component} from 'react';
import {inject, observer} from "mobx-react";

import './Product.scss'

@inject('stores')
@observer
class Product extends Component {
    state = {
        product_id: null,
        user_id: null,
        count: 1
    };

    async componentDidMount() {
        if (this.props.match.params.product_id && this.props.match.params.product_id !== "") {
            let product_id = this.props.match.params.product_id;
            await this.props.stores.ProductStore.setProduct(product_id);
            this.setState({
                product_id: product_id
            });
        }

        if (this.props.stores.UserStore.current_user !== null && this.props.stores.UserStore.current_user.id !== "") {
            this.setState({
                user_id: this.props.stores.UserStore.current_user.id
            });
        }
    }

    render() {
        let p = this.props.stores.ProductStore.current_product;

        if (p === null)
            return <div/>;

        let imageSrc = `http://localhost:8080/download/product/${p.id}`;

        return (
            <div className='product-item'>
                <div className='product-name'>{p.name}</div>
                <img className='product-image' src={imageSrc} alt="제품이미지"/>
                <div>제조사 : {p.company}</div>
                <div>가격 : {p.price}원</div>
                <input type="number" onChange={this.updateCount} defaultValue={1}/>
                <button onClick={this.goCart}>장바구니</button>
            </div>
        );
    }

    goCart = () => {
        if (this.state.user_id === null) {
            alert("로그인 해주세요");
        } else {
            this.props.stores.CartStore.addCart(this.state);
            alert("장바구니에 담겼습니다");
        }
    };

    updateCount = event => {
        this.setState({
            count: event.target.value
        });
    };
}

export default Product;