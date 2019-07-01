import React, {Component} from 'react';
import {inject, observer} from "mobx-react";
import {Link} from 'react-router-dom';

import './ProductItem.scss'

@inject('stores')
@observer
class ProductItem extends Component {
    state = {
        id: null,
        name: null,
        price: null,
        image: null,
        content: null
    };

    async componentDidMount() {
        if (this.props.product_id != null) {
            let product = await this.props.stores.ProductStore.getProduct(this.props.product_id);
            this.setState({
                ...this.state,
                id: product.id,
                name: product.name,
                price: product.price,
                image: product.image,
                content: product.content
            });
        }
    }

    render() {
        if (this.state.id === null)
            return <div/>;

        let productLink = `/product/${this.state.id}`;
        let imageSrc = `http://localhost:8080/download/product/${this.state.id}`;
        return (
            <div className='product-item-container'>
                <Link to={productLink}>

                    <div className='product-item-image-container'>
                        <img  className='product-item-image' src={imageSrc} alt="제품이미지"/>
                    </div>

                    <div className='product-item-info-container'>
                        <div className='product-item-name'>{this.state.name}</div>
                        <div className='product-item-content'>{this.state.content}</div>
                    </div>
                    <div className='product-item-price-container'>
                        <div className='product-item-price'>₩{this.state.price}</div>
                    </div>
                </Link>
            </div>
        );
    }
}

export default ProductItem;