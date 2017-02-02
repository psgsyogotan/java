package jpl.ch05.ex01;

public class WhichNest {

}
//AttributeインタフェースがAttrのネストした型であるべき

//理由：Attrのprivateなフィールドを利用することを考えたとき、ネストしたインタフェースの実装をつくることで、
//Attrクラスの外側に向けてAttrのフィールドを公開することなくAttrkクラスとやり取りできることが便利だと思ったので