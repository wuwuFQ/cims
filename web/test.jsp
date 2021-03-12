<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <script type="application/javascript">
        /**
         * JSON两种类型
         * 1.JSON对象
         *  {}
         * 2.JSON数组
         *  []
         */
        // let object = {"userName": "丁浩", "userAge": 21, "userBirthday": "1999-01-21"};
        // object.userGender = "男";
        // alert( JSON.stringify(object) );

        // let array = [
        //     {"userName": "丁浩", "userAge": 21, "userBirthday": "1999-01-21"},
        //     {"userName": "丁浩1", "userAge": 22, "userBirthday": "1999-01-22"}
        // ];
        // alert(array[1].userName);

        // let city = [
        //     {"id": 1, "name": "北京", "child": [
        //         {"id": 11, "name": "海淀", "child": [
        //             {"id": 111, "name": "上地街道", "child": [
        //                 {"id": 1111, "name": "上地三街"},
        //                 {"id": 1112, "name": "上地四街"}
        //             ]},
        //             {"id": 112, "name": "马连洼街道"}
        //         ]},
        //         {"id": 12, "name": "朝阳"},
        //         {"id": 13, "name": "昌平"}
        //     ]},
        //     {"id": 2, "name": "天津"}
        // ];
        //
        // alert( city[0].child[0].child[0].child[0].name );

        // let object = {
        //     "count": 1291,
        //     "list": [
        //         {"id": 1, "name": "北京"},
        //         {"id": 13, "name": "昌平"},
        //         {"id": 12, "name": "朝阳"}
        //     ],
        //     "list1": [],
        //     "object1": {},
        //     "object2": {
        //         "list": []
        //     }
        // }

        let object = {"userName": "丁浩", "userAge": 21, "userBirthday": "1999-01-21"};
        let string = JSON.stringify(object);
        let object1 = JSON.parse(string);

    </script>
</body>
</html>
