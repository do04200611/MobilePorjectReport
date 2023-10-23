<H1>모바일 프로젝트 및 수업 때 내주신 과제 PPT 파일이 모여있는 레파지토리입니다.</H1>

최종 시행 영상입니다.


### [해당 github 사이트를 소개하는 페이지](https://do04200611.github.io/MobilePorjectReport/)

https://github.com/do04200611/MobilePorjectReport/assets/74278578/0c99e440-9f62-4377-b64a-db78434d90ea

![1](https://github.com/do04200611/MobilePorjectReport/assets/74278578/e1d22d49-c287-4bd4-9382-8b5c1d9edaa8)
![2](https://github.com/do04200611/MobilePorjectReport/assets/74278578/527f57e9-d97b-4160-bfff-371994a8b4f0)


![3](https://github.com/do04200611/MobilePorjectReport/assets/74278578/a437991c-cced-409a-bc8a-42d9ec5a40e9)
![4](https://github.com/do04200611/MobilePorjectReport/assets/74278578/a9710464-fdc5-4d85-88a2-d6e0427b741b)
![5](https://github.com/do04200611/MobilePorjectReport/assets/74278578/7ebda1fc-d12d-4ea5-a641-88290fe3f2ba)
![6](https://github.com/do04200611/MobilePorjectReport/assets/74278578/8962ef72-b6b2-4eac-af11-1f504d79dfa7)
![5](https://github.com/do04200611/MobilePorjectReport/assets/74278578/d9d547f3-f495-4cb0-b93f-d522fbbc2735)
![6](https://github.com/do04200611/MobilePorjectReport/assets/74278578/a7b757bb-88d4-4b2c-b4b8-383da7acfb35)
![7](https://github.com/do04200611/MobilePorjectReport/assets/74278578/f417bfdc-a604-46d6-b15d-010a78451fd1)
![8](https://github.com/do04200611/MobilePorjectReport/assets/74278578/b0def30a-258c-4194-b721-fbffe8b0c305)
![9](https://github.com/do04200611/MobilePorjectReport/assets/74278578/3778b5e3-17b1-4880-9da6-7ddfb9eb0b47)
![11](https://github.com/do04200611/MobilePorjectReport/assets/74278578/12238bab-72fe-49fc-b0a7-caf8db322377)


![10](https://github.com/do04200611/MobilePorjectReport/assets/74278578/5b183d02-fb66-47b5-a2f4-960f53c24140)


<p align="center">
  <a href="http://lovera.maxam.now.sh/">
    <img src="https://user-images.githubusercontent.com/25841814/79395484-5081ae80-7fac-11ea-9e27-ac91472e31dd.png" alt="screenshot" width="500">
  </a>
  <h3 align="center">📌✨productive-box</h3>
</p>

<p align="center">
   <img src="https://img.shields.io/badge/language-typescript-blue?style"/>
   <img src="https://img.shields.io/github/license/maxam2017/productive-box"/>
   <img src="https://img.shields.io/github/stars/maxam2017/productive-box"/>
   <img src="https://img.shields.io/github/forks/maxam2017/productive-box"/>
</p>
<p align="center">
   Are you an early 🐤 or a night 🦉?
   <br/>
   When are you most productive during the day?
   <br/>
   Let's check out in gist!
</p>

---

> This project is inspired by an awesome pinned-gist project.<br/>Find more in https://github.com/matchai/awesome-pinned-gists

## Overview
This project uses GitHub graphQL API to get the commit histories and write into the gist by [rest.js](https://github.com/octokit/rest.js#readme)

## Setup

### Prep work
1. Create a new public GitHub Gist (https://gist.github.com/)
1. Create a token with the `gist` and `repo` scope and copy it. (https://github.com/settings/tokens/new)
   > enable `repo` scope seems **DANGEROUS**<br/>
   > but this GitHub Action only accesses your commit timestamp in repository you contributed.

### Project setup

1. Fork this repo
1. Open the "Actions" tab of your fork and click the "enable" button
1. Edit the [environment variable](https://github.com/maxam2017/productive-box/blob/master/.github/workflows/schedule.yml#L17-L18) in `.github/workflows/schedule.yml`:

   - **GIST_ID:** The ID portion from your gist url: `https://gist.github.com/maxam2017/`**`9842e074b8ee46aef76fd0d493bae0ed`**.
   - **TIMEZONE:** The timezone of your location, eg. `Asia/Taipei` for Taiwan, `America/New_York` for America in New York, etc.

1. Go to the repo **Settings > Secrets**
1. Add the following environment variables:
   - **GH_TOKEN:** The GitHub token generated above.
1. [Pin the newly created Gist](https://help.github.com/en/github/setting-up-and-managing-your-github-profile/pinning-items-to-your-profile)

