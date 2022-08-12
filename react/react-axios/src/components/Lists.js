import React from 'react'

export default function Lists({rank, movieNm, openDt}) {
  return (
    <div key={rank}>{rank} {movieNm}</div>
  )
}
