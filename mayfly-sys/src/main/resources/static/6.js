(window.webpackJsonp=window.webpackJsonp||[]).push([[6],{191:function(e,t,n){"use strict";n.d(t,"b",(function(){return i})),n.d(t,"c",(function(){return o})),n.d(t,"a",(function(){return s}));var r=n(18),i={resource:r.a.code("resource"),save:r.a.code("resource:save"),update:r.a.code("resource:update"),del:r.a.code("resource:delete")},o={role:r.a.code("role"),del:r.a.code("role:delete"),saveResources:r.a.code("role:saveResources")},s={account:r.a.code("account"),del:r.a.code("account:delete"),saveRoles:r.a.code("account:saveRoles")}},202:function(e,t,n){var r=n(37),i=n(218);"string"==typeof(i=i.__esModule?i.default:i)&&(i=[[e.i,i,""]]);var o={insert:"head",singleton:!1},s=(r(e.i,i,o),i.locals?i.locals:{});e.exports=s},203:function(e,t,n){var r=n(37),i=n(220);"string"==typeof(i=i.__esModule?i.default:i)&&(i=[[e.i,i,""]]);var o={insert:"head",singleton:!1},s=(r(e.i,i,o),i.locals?i.locals:{});e.exports=s},217:function(e,t,n){"use strict";var r=n(202);n.n(r).a},218:function(e,t,n){(t=n(38)(!1)).push([e.i,"",""]),e.exports=t},219:function(e,t,n){"use strict";var r=n(203);n.n(r).a},220:function(e,t,n){(t=n(38)(!1)).push([e.i,".menu .el-tree-node__content {\n  height: 40px;\n  line-height: 40px;\n}\n.none-select {\n  moz-user-select: -moz-none;\n  -moz-user-select: none;\n  -o-user-select: none;\n  -khtml-user-select: none;\n  -webkit-user-select: none;\n  -ms-user-select: none;\n  user-select: none;\n}\n",""]),e.exports=t},233:function(e,t,n){"use strict";n.r(t);var r,i,o,s,a=n(184),l=n.n(a),c=n(185),u=n.n(c),d=n(187),p=n(186),m=n(189),f={name:"ResourceEdit",props:{dialogFormVisible:Boolean,data:[Object,Boolean],title:String,type:Number,typeDisabled:Boolean},data:function(){return{enums:m.a,dialogForm:{title:"",visible:!1,data:{}},props:{value:"id",label:"name",children:"children"},form:{id:null,name:null,pid:null,code:null,icon:null,type:null,weight:null},btnLoading:!1,rules:{name:[{required:!0,message:"请输入资源名称",trigger:["change","blur"]}],weight:[{required:!0,message:"请输入序号",trigger:["change","blur"]}]}}},watch:{data:{handler:function(){this.data&&this.$Utils.copyProperties(this.data,this.form)},deep:!0}},methods:{handleChange:function(){},addOperation:function(){this.dialogForm.visible=!0},operationChange:function(e){this.operations.push(e),this.dialogForm.visible=!1},btnOk:function(){var e=this,t=this.form.id?p.c.update:p.c.save;this.$refs.menuForm.validate((function(n){if(!n)return!1;t.request(e.form).then((function(t){e.$emit("val-change",e.form),e.btnLoading=!0,e.$message.success("保存成功"),setTimeout((function(){e.btnLoading=!1}),1e3),e.cancel()}))}))},cancel:function(){var e=this;this.$emit("cancel"),setTimeout((function(){e.$refs.menuForm.resetFields(),e.$Utils.resetProperties(e.form)}),200)}},mounted:function(){},components:{}},g=(n(217),n(66)),h=Object(g.a)(f,(function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"menu-dialog"},[n("el-dialog",{attrs:{title:e.title,visible:e.dialogFormVisible,"show-close":!1,width:"28%"}},[n("el-form",{ref:"menuForm",attrs:{model:e.form,rules:e.rules,"label-width":"85px",size:"small"}},[n("el-form-item",{attrs:{prop:"name",label:"名称",required:""}},[n("el-input",{attrs:{placeholder:"请输入资源名","auto-complete":"off"},model:{value:e.form.name,callback:function(t){e.$set(e.form,"name","string"==typeof t?t.trim():t)},expression:"form.name"}})],1),e._v(" "),n("el-form-item",{attrs:{prop:"type",label:"类型",required:""}},e._l(e.enums.ResourceTypeEnum,(function(t){return n("el-radio",{key:t.value,attrs:{disabled:e.typeDisabled,label:t.value},model:{value:e.form.type,callback:function(t){e.$set(e.form,"type",t)},expression:"form.type"}},[e._v(e._s(t.label))])})),1),e._v(" "),e.form.type===e.enums.ResourceTypeEnum.MENU.value?n("el-form-item",{attrs:{label:"样式"}},[n("el-input",{attrs:{placeholder:"请输入菜单图标样式"},model:{value:e.form.icon,callback:function(t){e.$set(e.form,"icon","string"==typeof t?t.trim():t)},expression:"form.icon"}})],1):e._e(),e._v(" "),e.form.type===e.enums.ResourceTypeEnum.MENU.value?n("el-form-item",{attrs:{prop:"code",label:"路由"}},[n("el-input",{attrs:{placeholder:"请输入路由code"},model:{value:e.form.code,callback:function(t){e.$set(e.form,"code","string"==typeof t?t.trim():t)},expression:"form.code"}})],1):e._e(),e._v(" "),n("el-form-item",{attrs:{prop:"code",label:"权限code"}},[n("el-input",{attrs:{placeholder:"请输入权限code"},model:{value:e.form.code,callback:function(t){e.$set(e.form,"code","string"==typeof t?t.trim():t)},expression:"form.code"}})],1),e._v(" "),n("el-form-item",{attrs:{label:"序号",prop:"weight",required:""}},[n("el-input",{attrs:{type:"number",placeholder:"请输入序号"},model:{value:e.form.weight,callback:function(t){e.$set(e.form,"weight","string"==typeof t?t.trim():t)},expression:"form.weight"}})],1)],1),e._v(" "),n("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center"}},[n("el-button",{attrs:{type:"primary",loading:e.btnLoading,size:"mini"},on:{click:e.btnOk}},[e._v("确 定")]),e._v(" "),n("el-button",{attrs:{size:"mini"},on:{click:e.cancel}},[e._v("取 消")])],1)],1)],1)}),[],!1,null,null,null).exports,v=n(191),y={data:function(){return{enums:m.a,permission:v.b,showBtns:!1,rightClickData:{},dialogForm:{title:"",visible:!1,data:{},typeDisabled:!0},data:[],props:{label:"name",children:"children"},defaultExpandedKeys:[]}},methods:{deleteMenu:function(e){var t=this;this.$confirm("此操作将删除 [".concat(e.name,"], 是否继续?"),"提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(){p.c.del.request({id:e.id}).then((function(e){t.$message.success("删除成功！"),t.search()}))}))},search:(s=u()(l.a.mark((function e(){var t;return l.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.next=2,p.c.list.request();case 2:t=e.sent,this.data=t;case 4:case"end":return e.stop()}}),e,this)}))),function(){return s.apply(this,arguments)}),addResource:function(e){var t=this.dialogForm;t.visible=!0,t.data={};var n=m.a.ResourceTypeEnum.MENU.value,r=m.a.ResourceTypeEnum.PERMISSION.value;if(!e)return t.typeDisabled=!0,t.data.type=n,void(t.title="添加顶级菜单");if(t.data.pid=e.id,t.title="添加“"+e.name+"”的子资源 ",null===e.children||0===e.children.length)t.typeDisabled=!1;else{t.typeDisabled=!0;var i=!1,o=!0,s=!1,a=void 0;try{for(var l,c=e.children[Symbol.iterator]();!(o=(l=c.next()).done);o=!0){if(l.value.type===r){i=!0;break}}}catch(e){s=!0,a=e}finally{try{o||null==c.return||c.return()}finally{if(s)throw a}}t.data.type=i?r:n}},editResource:(o=u()(l.a.mark((function e(t){return l.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return this.dialogForm.visible=!0,e.next=3,p.c.detail.request({id:t.id});case 3:this.dialogForm.data=e.sent,this.dialogForm.typeDisabled=!0,this.dialogForm.title="修改“"+t.name+"”菜单";case 6:case"end":return e.stop()}}),e,this)}))),function(e){return o.apply(this,arguments)}),valChange:function(e){this.search(),this.dialogForm.visible=!1},editorCancel:function(){this.dialogForm.visible=!1,this.dialogForm.data=null},changeStatus:(i=u()(l.a.mark((function e(t,n){return l.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.next=2,p.c.changeStatus.request({id:t.id,status:n});case 2:t.status=n,this.$message.success((1===n?"启用":"禁用")+"成功！");case 4:case"end":return e.stop()}}),e,this)}))),function(e,t){return i.apply(this,arguments)}),handleNodeExpand:function(e,t){var n=t.data.id;this.defaultExpandedKeys.includes(n)||this.defaultExpandedKeys.push(n)},handleNodeCollapse:function(e,t){this.removeDeafultExpandId(t.data.id);var n=t.childNodes,r=!0,i=!1,o=void 0;try{for(var s,a=n[Symbol.iterator]();!(r=(s=a.next()).done);r=!0){var l=s.value;if(2==l.data.type)return;l.expanded&&this.removeDeafultExpandId(l.data.id),this.handleNodeCollapse(e,l)}}catch(e){i=!0,o=e}finally{try{r||null==a.return||a.return()}finally{if(i)throw o}}},removeDeafultExpandId:function(e){var t=this.defaultExpandedKeys.indexOf(e);t>-1&&this.defaultExpandedKeys.splice(t,1)},info:(r=u()(l.a.mark((function e(t){var n;return l.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.next=2,p.c.detail.request({id:t.id});case 2:if((n=e.sent).type!==m.a.ResourceTypeEnum.MENU.value){e.next=6;break}return this.$alert('<strong style="margin-right: 18px">名称:</strong>'+n.name+' <br/><strong style="margin-right: 18px">图标:</strong>'+(n.icon?n.icon:"无")+' <br/><strong style="margin-right: 18px">路由:</strong>'+(n.url?n.url:"无")+' <br/><strong style="margin-right: 18px">权限code:</strong>'+(n.code?n.code:"无")+' <br/><strong style="margin-right: 18px">权重:</strong>'+n.weight+' <br/><strong style="margin-right: 18px">创建人:</strong>'+n.createAccount+' <br/><strong style="margin-right: 18px">创建时间:</strong>'+n.createTime+' <br/><strong style="margin-right: 18px">修改人:</strong>'+n.updateAccount+' <br/><strong style="margin-right: 18px">修改时间:</strong>'+n.updateTime,"菜单详情",{type:"info",dangerouslyUseHTMLString:!0,closeOnClickModal:!0,showConfirmButton:!1}).catch((function(e){})),e.abrupt("return");case 6:this.$alert('<strong style="margin-right: 18px">名称:</strong>'+n.name+' <br/><strong style="margin-right: 18px">权限code:</strong>'+(n.code?n.code:"无")+' <br/><strong style="margin-right: 18px">权重:</strong>'+n.weight+' <br/><strong style="margin-right: 18px">创建人:</strong>'+n.createAccount+' <br/><strong style="margin-right: 18px">创建时间:</strong>'+n.createTime+' <br/><strong style="margin-right: 18px">修改人:</strong>'+n.updateAccount+' <br/><strong style="margin-right: 18px">修改时间:</strong>'+n.updateTime,"权限详情",{type:"info",dangerouslyUseHTMLString:!0,closeOnClickModal:!0,showConfirmButton:!1}).catch((function(e){}));case 7:case"end":return e.stop()}}),e,this)}))),function(e){return r.apply(this,arguments)})},components:{ToolBar:d.a,ResourceEdit:h},mounted:function(){this.search()}},b=(n(219),Object(g.a)(y,(function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"menu"},[n("ToolBar",[n("div",[n("span",{staticStyle:{"font-size":"14px"}},[n("i",{staticClass:"el-icon-info"}),e._v("红色字体表示禁用状态\n      ")])]),e._v(" "),n("el-button",{directives:[{name:"permission",rawName:"v-permission",value:e.permission.save.code,expression:"permission.save.code"}],attrs:{type:"primary",icon:"el-icon-plus",size:"mini"},on:{click:function(t){return e.addResource(!1)}}},[e._v("添加")])],1),e._v(" "),n("el-tree",{staticClass:"none-select",attrs:{indent:38,"node-key":"id",props:e.props,data:e.data,"default-expanded-keys":e.defaultExpandedKeys,"expand-on-click-node":!1},on:{"node-expand":e.handleNodeExpand,"node-collapse":e.handleNodeCollapse},scopedSlots:e._u([{key:"default",fn:function(t){t.node;var r=t.data;return n("span",{staticClass:"custom-tree-node"},[r.type===e.enums.ResourceTypeEnum.MENU.value?n("span",{staticStyle:{"font-size":"13px"}},[n("span",{staticStyle:{color:"#3c8dbc"}},[e._v("【")]),e._v("\n        "+e._s(r.name)+"\n        "),n("span",{staticStyle:{color:"#3c8dbc"}},[e._v("】")]),e._v(" "),null!==r.children?n("el-tag",{attrs:{size:"mini"}},[e._v(e._s(r.children.length))]):e._e()],1):e._e(),e._v(" "),r.type===e.enums.ResourceTypeEnum.PERMISSION.value?n("span",{staticStyle:{"font-size":"13px"}},[n("span",{staticStyle:{color:"#3c8dbc"}},[e._v("【")]),e._v(" "),n("span",{style:1==r.status?"color: #67c23a;":"color: #f67c6c;"},[e._v(e._s(r.name))]),e._v(" "),n("span",{staticStyle:{color:"#3c8dbc"}},[e._v("】")])]):e._e(),e._v(" "),n("el-link",{staticStyle:{"margin-left":"25px"},attrs:{icon:"el-icon-view",type:"info",underline:!1},on:{click:function(t){return e.info(r)}}}),e._v(" "),n("el-link",{directives:[{name:"permission",rawName:"v-permission",value:e.permission.update.code,expression:"permission.update.code"}],attrs:{type:"primary",icon:"el-icon-edit",underline:!1},on:{click:function(t){return e.editResource(r)}}}),e._v(" "),r.type===e.enums.ResourceTypeEnum.MENU.value?n("el-link",{directives:[{name:"permission",rawName:"v-permission",value:e.permission.save.code,expression:"permission.save.code"}],attrs:{icon:"el-icon-circle-plus-outline",underline:!1,type:"success"},on:{click:function(t){return e.addResource(r)}}}):e._e(),e._v(" "),1===r.status&&r.type===e.enums.ResourceTypeEnum.PERMISSION.value?n("el-link",{directives:[{name:"permission",rawName:"v-permission",value:e.permission.resource.code,expression:"permission.resource.code"}],attrs:{icon:"el-icon-circle-close",underline:!1,type:"warning"},on:{click:function(t){return e.changeStatus(r,0)}}}):e._e(),e._v(" "),0===r.status&&r.type===e.enums.ResourceTypeEnum.PERMISSION.value?n("el-link",{directives:[{name:"permission",rawName:"v-permission",value:e.permission.resource.code,expression:"permission.resource.code"}],attrs:{type:"success",icon:"el-icon-circle-check",underline:!1,plain:""},on:{click:function(t){return e.changeStatus(r,1)}}}):e._e(),e._v(" "),null==r.children?n("el-link",{directives:[{name:"permission",rawName:"v-permission",value:e.permission.del.code,expression:"permission.del.code"}],attrs:{type:"danger",icon:"el-icon-remove-outline",underline:!1,plain:""},on:{click:function(t){return e.deleteMenu(r)}}}):e._e()],1)}}])}),e._v(" "),n("ResourceEdit",{attrs:{title:e.dialogForm.title,dialogFormVisible:e.dialogForm.visible,data:e.dialogForm.data,typeDisabled:e.dialogForm.typeDisabled,departTree:e.data,type:e.dialogForm.type},on:{"val-change":e.valChange,cancel:function(t){return e.editorCancel()}}})],1)}),[],!1,null,null,null).exports);n.d(t,"default",(function(){return b}))}}]);