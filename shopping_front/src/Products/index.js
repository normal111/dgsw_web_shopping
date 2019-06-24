import React from 'react';

const Products = ({match}) => (
    <div>
        {match.params.id}번 카테고리의 상품을 보여줌
    </div>
);

export default Products;