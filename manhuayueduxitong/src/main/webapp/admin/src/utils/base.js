const base = {
    get() {
        return {
            url : "http://localhost:8080/manhuayueduxitong/",
            name: "manhuayueduxitong",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/manhuayueduxitong/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "漫画阅读系统"
        } 
    }
}
export default base
