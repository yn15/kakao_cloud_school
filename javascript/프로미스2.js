let promise = new Promise(function(resolve, reject){
    setTimeout( ()=>{
        s = 0;
        for(i=1; i<=100; i++){
            s+=i;
        }
        resolve(s);
    }, 1000)
})
.then( (value)=>{
    console.log(value);
})
.catch(error=>{
    console.log(error);
})
.finally(
    ()=>{console.log("ending............")}
);

console.log(promise);