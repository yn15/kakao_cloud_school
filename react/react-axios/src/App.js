import axios from 'axios';
import { useState } from 'react';
import './App.css';
import Lists from './components/Lists';

function App() {

  const [movieData, setMovieData] = useState([]);

  const option = {
    url: 'http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json',
    method: 'get',
    params: {
      key: 'ae2de2e13f21a1aab04ed94560a6d565',
      targetDt: '20220801'
    },
    responseType: 'json'
  }

  const changeDate = (e) => {
    let date = (e.target.value).replace(/\-/g, '');
    option['params']['targetDt'] = date;
    callAjax();
  }

  const callAjax = () => {
    axios(option)
    .then(function(response) {
      
      let data = response.data['boxOfficeResult']['dailyBoxOfficeList'];
      setMovieData(data);
      //console.log(movieData);
    })
    .catch(function() {
      console.log('Error');
    })
    .finally(function() {
      console.log('무조건 출력');
    })
  }

  return (
    <div className="flex items-center justify-center w-screen h-screen bg-blue-100">
      <div className="w-full p-6 m-4 bg-white rounded shadow md:w-3/4 md:max-w-lg lg:w-3/4 lg: max-w-lg">
        <div className="flex justify-between mb-3">
          <h1>영화 일일 순위</h1>
        </div>
        <input type="date" onSelect={changeDate}/>  
        {/* <button onClick={changeDate}>Search</button> */}
        {movieData.map((data, index) => (
          
          <Lists 
            rank = {data.rank}
            movieNm = {data.movieNm}
            openDt = {data.openDt}
          />
        ))}
        <div class="bg-white">
  <div class="max-w-2xl mx-auto py-16 px-4 sm:py-24 sm:px-6 lg:max-w-7xl lg:px-8">
    <div class="mt-6 grid grid-cols-1 gap-y-10 gap-x-6 sm:grid-cols-2 lg:grid-cols-4 xl:gap-x-8">
      <div class="group relative">
        <div class="w-full min-h-80 bg-gray-200 aspect-w-1 aspect-h-1 rounded-md overflow-hidden group-hover:opacity-75 lg:h-80 lg:aspect-none">
          <img src="https://tailwindui.com/img/ecommerce-images/product-page-01-related-product-01.jpg" alt="Front of men&#039;s Basic Tee in black." class="w-full h-full object-center object-cover lg:w-full lg:h-full" />
        </div>
        <div class="mt-4 flex justify-between">
          <div>
            <h3 class="text-sm text-gray-700">
              <a href="#">
                <span aria-hidden="true" class="absolute inset-0"></span>
                Basic Tee
              </a>
            </h3>
            <p class="mt-1 text-sm text-gray-500">Black</p>
          </div>
          <p class="text-sm font-medium text-gray-900">$35</p>
        </div>
      </div>
    </div>
  </div>
</div>
        
      </div>
    </div>
  );
}

export default App;
