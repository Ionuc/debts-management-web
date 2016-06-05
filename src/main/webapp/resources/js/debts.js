function operateFormatter(value, row, index) {
        return [
            '<a class="like" href="http://localhost:9000/DebtsManagementWeb/payDebt/' + row.id + '" title="Like">',
                'Pay',
            '</a>'
        ].join('');
    }