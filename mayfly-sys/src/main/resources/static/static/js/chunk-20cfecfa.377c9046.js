(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-20cfecfa"],{"050b":function(e,t,r){"use strict";var s=r("a7e9");t["a"]={ResourceTypeEnum:(new s["a"]).add("MENU","菜单",1).add("PERMISSION","权限",2),accountStatus:(new s["a"]).add("ENABLE","正常",1).add("DISABLE","禁用",0),logType:(new s["a"]).add("UPDATE","修改",2).add("DELETE","删除",3).add("SYS_LOG","系统",4).add("ERR_LOG","异常",5)}},2945:function(e,t,r){"use strict";var s=r("1462"),a=r("a340"),n=r("d789"),o=function(){function e(t,r){Object(s["a"])(this,e),this.url=t,this.method=r}return Object(a["a"])(e,[{key:"setUrl",value:function(e){return this.url=e,this}},{key:"setMethod",value:function(e){return this.method=e,this}},{key:"getUrl",value:function(){return n["a"].getApiUrl(this.url)}},{key:"request",value:function(e){return n["a"].send(this,e)}}],[{key:"create",value:function(t,r){return new e(t,r)}}]),e}();t["a"]=o},"90aa":function(e,t,r){"use strict";var s=r("1c8b"),a=r("07a2"),n=r("2732"),o=r("783d");s({target:"String",proto:!0,forced:!o("includes")},{includes:function(e){return!!~String(n(this)).indexOf(a(e),arguments.length>1?arguments[1]:void 0)}})},9302:function(e,t,r){"use strict";var s=r("1c8b"),a=r("692f"),n=r("da10"),o=r("d7e1"),i=[].join,c=a!=Object,l=o("join",",");s({target:"Array",proto:!0,forced:c||!l},{join:function(e){return i.call(n(this),void 0===e?",":e)}})},"9cf3":function(e,t,r){"use strict";var s=r("b2a2"),a=r("857c"),n=r("2732"),o=r("9d5c"),i=r("59da");s("search",1,(function(e,t,r){return[function(t){var r=n(this),s=void 0==t?void 0:t[e];return void 0!==s?s.call(t,r):new RegExp(t)[e](String(r))},function(e){var s=r(t,e,this);if(s.done)return s.value;var n=a(e),c=String(this),l=n.lastIndex;o(l,0)||(n.lastIndex=0);var u=i(n,c);return o(n.lastIndex,l)||(n.lastIndex=l),null===u?-1:u.index}]}))},"9d5c":function(e,t){e.exports=Object.is||function(e,t){return e===t?0!==e||1/e===1/t:e!=e&&t!=t}},a05d:function(e,t,r){"use strict";r.d(t,"b",(function(){return a})),r.d(t,"c",(function(){return n})),r.d(t,"a",(function(){return o}));var s=r("2262"),a={resource:s["a"].code("resource"),save:s["a"].code("resource:save"),update:s["a"].code("resource:update"),del:s["a"].code("resource:delete")},n={role:s["a"].code("role"),del:s["a"].code("role:delete"),saveResources:s["a"].code("role:saveResources")},o={account:s["a"].code("account"),changeStatus:s["a"].code("account:changeStatus"),del:s["a"].code("account:delete"),saveRoles:s["a"].code("account:saveRoles")}},a7e9:function(e,t,r){"use strict";r.d(t,"a",(function(){return n}));var s=r("1462"),a=r("a340"),n=function(){function e(){Object(s["a"])(this,e)}return Object(a["a"])(e,[{key:"add",value:function(e,t,r){return this[e]={label:t,value:r},this}},{key:"getLabelByValue",value:function(e){if(void 0===e||null===e)return"";for(var t in this){var r=this[t];if(r&&r.value===e)return r.label}return""}}]),e}()},b130:function(e,t,r){"use strict";var s=r("1c8b"),a=r("45af").includes,n=r("258f"),o=r("ff9c"),i=o("indexOf",{ACCESSORS:!0,1:0});s({target:"Array",proto:!0,forced:!i},{includes:function(e){return a(this,e,arguments.length>1?arguments[1]:void 0)}}),n("includes")},c33f:function(e,t,r){"use strict";var s=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("span",[r("span",{staticStyle:{"margin-right":"8px"}},[e._t("default")],2),r("el-tooltip",{attrs:{content:e.content,placement:e.placement}},[r("i",{staticClass:"el-icon-question",staticStyle:{cursor:"pointer"}})])],1)},a=[],n={name:"HelpHint",props:{placement:{default:"top"},content:String},data:function(){return{}}},o=n,i=r("9ca4"),c=Object(i["a"])(o,s,a,!1,null,null,null);t["a"]=c.exports},d21a:function(e,t,r){"use strict";r.d(t,"c",(function(){return a})),r.d(t,"d",(function(){return n})),r.d(t,"a",(function(){return o})),r.d(t,"b",(function(){return i}));var s=r("2945"),a={list:s["a"].create("/sys/resources","get"),detail:s["a"].create("/sys/resources/{id}","get"),save:s["a"].create("/sys/resources","post"),update:s["a"].create("/sys/resources/{id}","put"),del:s["a"].create("/sys/resources/{id}","delete"),changeStatus:s["a"].create("/sys/resources/{id}/{status}","put")},n={list:s["a"].create("/sys/roles","get"),save:s["a"].create("/sys/roles","post"),update:s["a"].create("/sys/roles/{id}","put"),del:s["a"].create("/sys/roles/{id}","delete"),roleResourceIds:s["a"].create("/sys/roles/{id}/resourceIds","get"),roleResources:s["a"].create("/sys/roles/{id}/resources","get"),saveResources:s["a"].create("/sys/roles/{id}/resources","post")},o={list:s["a"].create("/sys/accounts","get"),save:s["a"].create("/sys/accounts","post"),update:s["a"].create("/sys/accounts/{id}","put"),del:s["a"].create("/sys/accounts/{id}","delete"),changeStatus:s["a"].create("/sys/accounts/{id}/{status}","put"),roleIds:s["a"].create("/sys/accounts/{id}/roleIds","get"),roles:s["a"].create("/sys/accounts/{id}/roles","get"),resources:s["a"].create("/sys/accounts/{id}/resources","get"),saveRoles:s["a"].create("/sys/accounts/{id}/roles","post")},i={list:s["a"].create("/sys/logs","get")}},eb99:function(e,t,r){"use strict";r.r(t),r.d(t,"default",(function(){return B}));var s=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{staticClass:"role-list"},[r("div",{staticClass:"toolbar"},[r("el-button",{directives:[{name:"permission",rawName:"v-permission",value:e.permission.role.code,expression:"permission.role.code"}],attrs:{type:"primary",icon:"el-icon-plus",size:"mini"},on:{click:function(t){return e.editRole(!1)}}},[e._v("添加")]),r("el-button",{directives:[{name:"permission",rawName:"v-permission",value:e.permission.role.code,expression:"permission.role.code"}],attrs:{disabled:null==e.chooseId,type:"primary",icon:"el-icon-edit",size:"mini"},on:{click:function(t){return e.editRole(e.chooseData)}}},[e._v("编辑")]),r("el-button",{directives:[{name:"permission",rawName:"v-permission",value:e.permission.saveResources.code,expression:"permission.saveResources.code"}],attrs:{disabled:null==e.chooseId,type:"success",icon:"el-icon-setting",size:"mini"},on:{click:function(t){return e.editResource(e.chooseData)}}},[e._v("分配菜单&权限")]),r("el-button",{directives:[{name:"permission",rawName:"v-permission",value:e.permission.del.code,expression:"permission.del.code"}],attrs:{disabled:null==e.chooseId,type:"danger",icon:"el-icon-delete",size:"mini"},on:{click:function(t){return e.deleteRole(e.chooseData)}}},[e._v("删除")]),r("div",{staticStyle:{float:"right"}},[r("el-input",{staticStyle:{width:"140px"},attrs:{placeholder:"请输入角色名称！",size:"small",clearable:""},on:{clear:e.search},model:{value:e.query.name,callback:function(t){e.$set(e.query,"name",t)},expression:"query.name"}}),r("el-button",{attrs:{type:"success",icon:"el-icon-search",size:"mini"},on:{click:e.search}})],1)],1),r("el-table",{ref:"table",staticStyle:{width:"100%"},attrs:{data:e.roles,border:""},on:{"current-change":e.choose}},[r("el-table-column",{attrs:{label:"选择",width:"50px"},scopedSlots:e._u([{key:"default",fn:function(t){return[r("el-radio",{attrs:{label:t.row.id},model:{value:e.chooseId,callback:function(t){e.chooseId=t},expression:"chooseId"}},[r("i")])]}}])}),r("el-table-column",{attrs:{prop:"name",label:"角色名称"}}),r("el-table-column",{attrs:{prop:"remark",label:"描述","min-width":"180px","show-overflow-tooltip":""}}),r("el-table-column",{attrs:{prop:"createTime",label:"创建时间"}}),r("el-table-column",{attrs:{prop:"updateTime",label:"修改时间"}}),r("el-table-column",{attrs:{label:"查看更多","min-width":"80px"},scopedSlots:e._u([{key:"default",fn:function(t){return[r("el-link",{directives:[{name:"permission",rawName:"v-permission",value:e.permission.role.code,expression:"permission.role.code"}],attrs:{type:"info"},on:{click:function(r){return e.showResources(t.row)}}},[e._v("菜单&权限")])]}}])})],1),r("el-pagination",{staticStyle:{"text-align":"center"},attrs:{background:"",layout:"prev, pager, next, total, jumper",total:e.total,"current-page":e.query.pageNum,"page-size":e.query.pageSize},on:{"current-change":e.handlePageChange,"update:currentPage":function(t){return e.$set(e.query,"pageNum",t)},"update:current-page":function(t){return e.$set(e.query,"pageNum",t)}}}),r("role-edit",{attrs:{title:e.roleEdit.title,visible:e.roleEdit.visible,data:e.roleEdit.role},on:{"update:visible":function(t){return e.$set(e.roleEdit,"visible",t)},"val-change":e.roleEditChange}}),r("resource-edit",{attrs:{visible:e.resourceDialog.visible,role:e.resourceDialog.role,resources:e.resourceDialog.resources,defaultCheckedKeys:e.resourceDialog.defaultCheckedKeys},on:{cancel:function(t){return e.cancelEditResources()}}}),r("show-resource",{attrs:{visible:e.showResourceDialog.visible,title:e.showResourceDialog.title,resources:e.showResourceDialog.resources},on:{"update:visible":function(t){return e.$set(e.showResourceDialog,"visible",t)},"update:resources":function(t){return e.$set(e.showResourceDialog,"resources",t)}}})],1)},a=[],n=(r("b130"),r("053b"),r("e35a"),r("90aa"),r("9cf3"),r("52ef")),o=(r("6a61"),r("cf7f")),i=r("1462"),c=r("a340"),l=r("bb06"),u=r("9691"),d=r("0372"),f=r("e4a1"),p=r("c33f"),h=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{staticClass:"role-dialog"},[r("el-dialog",{attrs:{title:e.title,visible:e.visible,"show-close":!1,width:"500px"}},[r("el-form",{attrs:{model:e.form,size:"small","label-width":"90px"}},[r("el-form-item",{attrs:{label:"角色名称:",required:""}},[r("el-input",{attrs:{"auto-complete":"off"},model:{value:e.form.name,callback:function(t){e.$set(e.form,"name",t)},expression:"form.name"}})],1),r("el-form-item",{attrs:{label:"角色描述:"}},[r("el-input",{attrs:{type:"textarea",rows:3,placeholder:"请输入角色描述"},model:{value:e.form.remark,callback:function(t){e.$set(e.form,"remark",t)},expression:"form.remark"}})],1)],1),r("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[r("el-button",{attrs:{type:"primary",loading:e.btnLoading,size:"small"},on:{click:e.btnOk}},[e._v("确 定")]),r("el-button",{attrs:{size:"small"},on:{click:function(t){return e.cancel()}}},[e._v("取 消")])],1)],1)],1)},v=[],b=r("d21a"),m=function(e){Object(l["a"])(r,e);var t=Object(u["a"])(r);function r(){var e;return Object(i["a"])(this,r),e=t.apply(this,arguments),e.form={id:null,name:"",remark:""},e.btnLoading=!1,e}return Object(c["a"])(r,[{key:"onRoleChange",value:function(){if(this.data)for(var e in this.form)this.form[e]=this.data[e];else for(var t in this.form)this.form[t]=""}},{key:"handleChange",value:function(){}},{key:"cancel",value:function(){this.$emit("update:visible",!1),this.$emit("cancel")}},{key:"btnOk",value:function(){var e=Object(o["a"])(regeneratorRuntime.mark((function e(){var t,r=this;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return this.form,t=this.form.id?b["d"].update:b["d"].save,e.next=4,t.request(this.form);case 4:this.$emit("val-change",this.form),this.cancel(),this.btnLoading=!0,setTimeout((function(){r.btnLoading=!1}),1e3);case 8:case"end":return e.stop()}}),e,this)})));function t(){return e.apply(this,arguments)}return t}()}]),r}(f["c"]);Object(d["a"])([Object(f["b"])({default:"新增角色"})],m.prototype,"title",void 0),Object(d["a"])([Object(f["b"])({default:!1})],m.prototype,"visible",void 0),Object(d["a"])([Object(f["b"])()],m.prototype,"data",void 0),Object(d["a"])([Object(f["d"])("data",{deep:!0})],m.prototype,"onRoleChange",null),m=Object(d["a"])([Object(f["a"])({name:"RoleEdit"})],m);var y=m,g=y,k=r("9ca4"),O=Object(k["a"])(g,h,v,!1,null,null,null),j=O.exports,w=r("a05d"),R=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",[r("el-dialog",{attrs:{title:"分配“"+e.role.name+"”菜单&权限",visible:e.visible,"show-close":!1,width:"400px",height:"400px"}},[r("el-tree",{ref:"menuTree",staticStyle:{height:"50vh",overflow:"auto"},attrs:{data:e.resources,"show-checkbox":"","node-key":"id","default-checked-keys":e.defaultCheckedKeys,props:e.defaultProps},scopedSlots:e._u([{key:"default",fn:function(t){var s=t.node,a=t.data;return r("span",{staticClass:"custom-tree-node"},[a.type==e.enums.ResourceTypeEnum.MENU.value?r("span",[e._v(e._s(s.label))]):e._e(),a.type==e.enums.ResourceTypeEnum.PERMISSION.value?r("span",{staticStyle:{color:"#67c23a"}},[e._v(e._s(s.label))]):e._e()])}}])}),r("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[r("el-button",{attrs:{type:"primary",size:"small"},on:{click:e.btnOk}},[e._v("确 定")]),r("el-button",{attrs:{size:"small"},on:{click:function(t){return e.$emit("cancel")}}},[e._v("取 消")])],1)],1)],1)},x=[],S=(r("b4fb"),r("9302"),r("050b")),E=function(e){Object(l["a"])(r,e);var t=Object(u["a"])(r);function r(){var e;return Object(i["a"])(this,r),e=t.apply(this,arguments),e.enums=S["a"],e.defaultProps={children:"children",label:"name"},e}return Object(c["a"])(r,[{key:"getAllLeafIds",value:function(e){var t,r=[],s=Object(n["a"])(e);try{for(s.s();!(t=s.n()).done;){var a=t.value;this.setLeafIds(a,r)}}catch(o){s.e(o)}finally{s.f()}return r}},{key:"setLeafIds",value:function(e,t){if(null!==e.children){var r,s=Object(n["a"])(e.children);try{for(s.s();!(r=s.n()).done;){var a=r.value;this.setLeafIds(a,t)}}catch(o){s.e(o)}finally{s.f()}}else t.push(e.id)}},{key:"btnOk",value:function(){var e=Object(o["a"])(regeneratorRuntime.mark((function e(){var t,r,s,a;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return t=this.$refs.menuTree,r=t.getCheckedKeys(),s=t.getHalfCheckedKeys(),a=[].concat(r,s).join(","),e.next=6,b["d"].saveResources.request({id:this.role["id"],resourceIds:a});case 6:this.$message.success("保存成功!"),this.$emit("cancel");case 8:case"end":return e.stop()}}),e,this)})));function t(){return e.apply(this,arguments)}return t}()}]),r}(f["c"]);Object(d["a"])([Object(f["b"])()],E.prototype,"visible",void 0),Object(d["a"])([Object(f["b"])({default:{}})],E.prototype,"role",void 0),Object(d["a"])([Object(f["b"])()],E.prototype,"defaultCheckedKeys",void 0),Object(d["a"])([Object(f["b"])()],E.prototype,"resources",void 0),Object(d["a"])([Object(f["b"])({default:"编辑资源"})],E.prototype,"title",void 0),E=Object(d["a"])([Object(f["a"])({name:"ResourceEdit"})],E);var _=E,D=_,I=Object(k["a"])(D,R,x,!1,null,null,null),C=I.exports,$=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",[r("el-dialog",{attrs:{title:e.title,visible:e.visible,width:"400px",height:"400px"},on:{close:e.closeDialog}},[r("el-tree",{staticStyle:{height:"50vh",overflow:"auto"},attrs:{data:e.resources,"node-key":"id",props:e.defaultProps,"expand-on-click-node":!1},scopedSlots:e._u([{key:"default",fn:function(t){var s=t.node,a=t.data;return r("span",{staticClass:"custom-tree-node"},[a.type==e.enums.ResourceTypeEnum.MENU.value?r("span",[e._v(e._s(s.label))]):e._e(),a.type==e.enums.ResourceTypeEnum.PERMISSION.value?r("span",{staticStyle:{color:"#67c23a"}},[e._v(e._s(s.label))]):e._e(),r("el-link",{staticStyle:{"margin-left":"25px"},attrs:{icon:"el-icon-view",type:"info",underline:!1},on:{click:function(t){return e.info(a)}}})],1)}}])})],1)],1)},L=[],q=function(e){Object(l["a"])(r,e);var t=Object(u["a"])(r);function r(){var e;return Object(i["a"])(this,r),e=t.apply(this,arguments),e.enums=S["a"],e.defaultProps={children:"children",label:"resourceName"},e}return Object(c["a"])(r,[{key:"info",value:function(e){this.$alert('<strong style="margin-right: 18px">资源名称:</strong>'+e.resourceName+' <br/><strong style="margin-right: 18px">分配账号:</strong>'+e.creator+' <br/><strong style="margin-right: 18px">分配时间:</strong>'+e.createTime,"分配信息",{type:"info",dangerouslyUseHTMLString:!0,closeOnClickModal:!0,showConfirmButton:!1}).catch((function(e){}))}},{key:"closeDialog",value:function(){this.$emit("update:visible",!1),this.$emit("update:resources",[])}}]),r}(f["c"]);Object(d["a"])([Object(f["b"])()],q.prototype,"visible",void 0),Object(d["a"])([Object(f["b"])()],q.prototype,"resources",void 0),Object(d["a"])([Object(f["b"])()],q.prototype,"title",void 0),q=Object(d["a"])([Object(f["a"])({name:"ShowResource"})],q);var N=q,T=N,z=Object(k["a"])(T,$,L,!1,null,null,null),P=z.exports,A=function(e){Object(l["a"])(r,e);var t=Object(u["a"])(r);function r(){var e;return Object(i["a"])(this,r),e=t.apply(this,arguments),e.permission=w["c"],e.dialogFormVisible=!1,e.currentEditPermissions=!1,e.query={pageNum:1,pageSize:10,name:null},e.total=0,e.roles=[],e.chooseId=null,e.chooseData=null,e.resourceDialog={visible:!1,role:{},resources:[],defaultCheckedKeys:[]},e.roleEdit={title:"角色编辑",visible:!1,role:{}},e.showResourceDialog={visible:!1,resources:[],title:""},e}return Object(c["a"])(r,[{key:"mounted",value:function(){this.search()}},{key:"search",value:function(){var e=Object(o["a"])(regeneratorRuntime.mark((function e(){var t;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return e.next=2,b["d"].list.request(this.query);case 2:t=e.sent,this.roles=t.list,this.total=t.total;case 5:case"end":return e.stop()}}),e,this)})));function t(){return e.apply(this,arguments)}return t}()},{key:"handlePageChange",value:function(e){this.query.pageNum=e,this.search()}},{key:"choose",value:function(e){e&&(this.chooseId=e.id,this.chooseData=e)}},{key:"roleEditChange",value:function(e){this.$message.success("修改成功！"),this.search()}},{key:"editRole",value:function(e){this.roleEdit.role=e||!1,this.roleEdit.visible=!0}},{key:"deleteRole",value:function(){var e=Object(o["a"])(regeneratorRuntime.mark((function e(t){return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return e.prev=0,e.next=3,this.$confirm("此操作将删除 [".concat(t.name,"] 该角色，以及与该角色有关的账号角色关联信息和资源角色关联信息, 是否继续?"),"提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"});case 3:return e.next=5,b["d"].del.request({id:t.id});case 5:this.$message.success("删除成功！"),this.search(),e.next=11;break;case 9:e.prev=9,e.t0=e["catch"](0);case 11:case"end":return e.stop()}}),e,this,[[0,9]])})));function t(t){return e.apply(this,arguments)}return t}()},{key:"showResources",value:function(){var e=Object(o["a"])(regeneratorRuntime.mark((function e(t){return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return e.next=2,b["d"].roleResources.request({id:t.id});case 2:this.showResourceDialog.resources=e.sent,this.showResourceDialog.title='"'+t.name+'"的菜单&权限',this.showResourceDialog.visible=!0;case 5:case"end":return e.stop()}}),e,this)})));function t(t){return e.apply(this,arguments)}return t}()},{key:"closeShowResourceDialog",value:function(){this.showResourceDialog.visible=!1,this.showResourceDialog.resources=[]}},{key:"editResource",value:function(){var e=Object(o["a"])(regeneratorRuntime.mark((function e(t){var r,s,a,o,i,c,l,u;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return e.next=2,b["c"].list.request(null);case 2:return r=e.sent,this.resourceDialog.resources=r,e.next=6,b["d"].roleResourceIds.request({id:t.id});case 6:s=e.sent,a=s,o=[],i=this.getAllLeafIds(this.resourceDialog.resources),c=Object(n["a"])(i);try{for(c.s();!(l=c.n()).done;)u=l.value,a.includes(u)&&o.push(u)}catch(d){c.e(d)}finally{c.f()}this.resourceDialog.defaultCheckedKeys=o,this.resourceDialog.visible=!0,this.resourceDialog.role=t;case 15:case"end":return e.stop()}}),e,this)})));function t(t){return e.apply(this,arguments)}return t}()},{key:"getAllLeafIds",value:function(e){var t,r=[],s=Object(n["a"])(e);try{for(s.s();!(t=s.n()).done;){var a=t.value;this.setLeafIds(a,r)}}catch(o){s.e(o)}finally{s.f()}return r}},{key:"setLeafIds",value:function(e,t){if(null!==e.children){var r,s=Object(n["a"])(e.children);try{for(s.s();!(r=s.n()).done;){var a=r.value;this.setLeafIds(a,t)}}catch(o){s.e(o)}finally{s.f()}}else t.push(e.id)}},{key:"cancelEditResources",value:function(){var e=this;this.resourceDialog.visible=!1,setTimeout((function(){e.resourceDialog.role=!1,e.resourceDialog.defaultCheckedKeys=[]}),10)}}]),r}(f["c"]);A=Object(d["a"])([Object(f["a"])({name:"RoleList",components:{HelpHint:p["a"],RoleEdit:j,ResourceEdit:C,ShowResource:P}})],A);var K=A,M=K,U=Object(k["a"])(M,s,a,!1,null,null,null),B=U.exports}}]);