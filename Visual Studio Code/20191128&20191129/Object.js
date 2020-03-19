var car={
    name:'car1',
    model:400,
    color:'black',

    company:{
        start:1997,
        logo:'star'
    },

    run:function(){
        alert('Car is running')
    }
};

alert(car.company.start);
car.run();